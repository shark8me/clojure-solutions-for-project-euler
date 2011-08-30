(ns problem42)

(def alphamap 
     (zipmap (map keyword '(A B C D E F G H I J K L M N O P Q R S T U V W X Y Z)) (range 1 27) ))
(defn getWords [] 
  (map #(second (. % split "\"")) (seq (. (slurp "C:\\Users\\kkarkera\\Downloads\\words.txt") split ","))))

(defn getNumbersForWord [word]
        (map #(get alphamap %) (map keyword ((comp rest seq) (. word split "")))))

(defn triangleNumbers [n]
     (/ (* n (+ n 1)) 2))

(def numbersForWords 
     (map getNumbersForWord (getWords)))

(defn findLargestNumber []
     (reduce #(max %1 %2) numbersForWords))

(defn makeTriangleSeq [num]
   (take-while #(>=  num %) (map triangleNumbers (iterate inc 1))))

(defn soln42 []
     (count (let [tset (set (makeTriangleSeq (findLargestNumber)))]
           (filter #(contains? tset %) numbersForWords))))