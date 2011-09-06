(ns problem43 (:use clojure.test))

(defn se1 [rhs]
 (map #(conj rhs %) 
      (clojure.set/difference  (set (range 0 10)) (set rhs))))

(defn se2 []
        (mapcat  #(se1 (vector %)) (range 0 10)))

(defn pandigitalSeq []
  (loop [inp (se2)]
    (if (= 10 (count (first inp)))
      inp
      (recur (iterAppend inp)))))

(defn toInt [iseq]
  (+ (* (first iseq) 100) (* (second iseq) 10) (last iseq)))

(is (= 234 (toInt [ 2 3 4])))

(defn getDigits [num digits]
  (let [splitD (rest (. (str num) split ""))]
    (map #(. Integer parseInt (nth splitD %)) digits)))

(is (= '(2 3 4) (getDigits "12345" [1 2 3])))

(defn getDigitsn [num digits]              
  (map #(nth num  %) digits))

(is (= '(2 3 4) (getDigitsn [0 1 2 3 4 5 6 7 8 9] [2 3 4])))


(defn divByX? [ num positions divisor]
  (zero? (rem (toInt (getDigits num positions)) divisor)))

(is true? (divByX? 1406357289 [2 3 4] 3))

(defn divByXn? [ num positions divisor]
  (zero? (rem (toInt (getDigitsn num positions)) divisor)))

(is (divByXn? [1 4 0 6 3 5 7 2 8 9] [2 3 4] 3))

(defn divBy2? [ num]
  (divByXn? num [1 2 3] 2))

(is (divBy2? [1 4 0 6 3 5 7 2 8 9]))
(is (not (divBy2? [1 4 0 5 3 5 7 2 8 9])))

(defn divBy3? [ num]
  (divByXn? num [2 3 4] 3))

(is (divBy3? [1 4 0 6 3 5 7 2 8 9]))
(is (not (divBy3? [1 4 0 6 4 5 7 2 8 9])))

(defn divBy5? [ num]
  (divByXn? num [3 4 5] 5))

(is (divBy5? [1 4 0 6 3 5 7 2 8 9]))
(is (not (divBy5? [1 4 0 6 3 6 7 2 8 9])))

(defn divBy7? [ num]
  (divByXn? num [4 5 6] 7))
(is (divBy7? [1 4 0 6 3 5 7 2 8 9]))
(is (not (divBy7? [1 4 0 6 3 6 7 2 8 9])))

(defn divBy11? [ num]
  (divByXn? num [5 6 7] 11))
(is (divBy11? [1 4 0 6 3 5 7 2 8 9]))

(defn divBy13? [ num]
  (divByXn? num [6 7 8] 13))

(is (divBy13? [1 4 0 6 3 5 7 2 8 9]))

(defn divBy17? [ num]
  (divByXn? num [7 8 9] 17))

(is (divBy17? [1 4 0 6 3 5 7 2 8 9]))

(defn divByAll? [num]
  (and (divBy2? num) (divBy3? num) (divBy5? num)
       (divBy7? num) (divBy11? num) (divBy13? num) (divBy17? num)))

(is (divByAll? [1 4 0 6 3 5 7 2 8 9]))
(is (not (divByAll? [1 4 0 6 3 5 7 2 1 9])))

(defn cvtToInt [iseq]
  (apply + (map #(* %1 %2) (reverse iseq) 
                (conj (take 10 (iterate #(* 10 %) 10)) 1))))

(is (= 1406357289 (cvtToInt [1 4 0 6 3 5 7 2 8 9] )))

(defn soln43 []    
  (apply + (map problem43/cvtToInt 
                (filter problem43/divByAll? (problem43/pandigitalSeq)))))

(is (= 16695334890 (soln43)))



