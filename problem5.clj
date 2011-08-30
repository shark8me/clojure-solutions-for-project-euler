(ns problem5
(:use clojure.test))


(defn isdivisibleby [num lDivisor]
                       (let [nums (range 2 (inc lDivisor))]
                         (every? #(zero? (mod num %)) nums)))

(is true (isdivisibleby 2520 10))

(defn soln5 [lDivisor]
(first (filter #(isdivisibleby % lDivisor) (iterate #(+ lDivisor %) lDivisor))))


(is 232792560 (soln5 20))

