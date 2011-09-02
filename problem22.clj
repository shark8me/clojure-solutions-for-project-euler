(ns problem22 (:use clojure.test))

(def alphamap 
     (zipmap (map keyword '(A B C D E F G H I J K L M N O P Q R S T U V W X Y Z)) (range 1 27) ))

(defn getWords [] 
     (map #(second (. % split "\"")) (seq (. (slurp "C:\\Users\\kkarkera\\Downloads\\names.txt") split ","))))

(defn getNumbersForWord [word]
        (map #(get alphamap %) (map keyword ((comp rest seq) (. word split "")))))

(is (= '(1 2 3 4) (getNumbersForWord "ABCD")))

(defn soln22 []
(let [words  (getWords)
            wcount (count words)
            wnum (map #(list %1 %2) (range 1 (inc wcount)) (sort words))
            wscore (map #(* (first %) (getNumbersForWord (second %))) wnum)]
        (apply + wscore)))