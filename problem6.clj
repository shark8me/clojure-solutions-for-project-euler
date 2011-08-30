(ns problem6
 (:use clojure.test))

(defn sumofsquares [num] (apply + (map #(* % %) (range 1 num))))

(is (= 385 (sumofsquares 11)))

(defn squareofsum [num] (let [sum (apply + (range 1 num))] (* sum sum)))

(is (= 3025 (squareofsum 11)))

(defn soln6 []
(- (squareofsum 101) (sumofsquares 101)))

(is (= (soln6) 25164150)) 