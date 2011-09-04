(ns problem10 (:use clojure.test) )

(use '[clojure.contrib.lazy-seqs :only (primes)])

(is (= '(2 3 5 7) (take-while #(> 10 %) primes)))

(defn sumOfPrimesGreaterThan [num]
     (apply + (take-while #(> num %) primes)))

(is (= 142913828922 (sumOfPrimesGreaterThan 2000000)))




