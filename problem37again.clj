(ns problem37again  (:use clojure.test))

(use '[clojure.contrib.lazy-seqs :only (primes)])
(use '[clojure.contrib.math :only (expt)])
(defn numSplit [num]
  (map #(. Integer parseInt %) (rest (. (str num ) split ""))))

(is (= '(2 3 7) (numSplit 237)))

(defn numCount [num]
  (count (numSplit num)))
(is (= 3 (numCount 237)))

(defn splitHeadFirst [n]
        (map #(rem n (expt 10 %)) (range (numCount n) 0 -1)))

(is (= '(12345 2345 345 45 5) (splitHeadFirst 12345)))

(defn splitTailFirst [n]
     (map #(quot n (expt 10 %)) (range 0 (numCount n) )))
(is (= '(12345 1234 123 12 1)) (splitTailFirst 12345))

(defn allSplit [n]
     (set (concat (splitHeadFirst n) (splitTailFirst n))))

(is (= '#{1 34 4 234 12 1234 123} (allSplit 1234)))

(defn areAllPrimes [ splitSet primeSet]
  (= (count splitSet) 
     (count (clojure.set/intersection splitSet primeSet))))

(is (areAllPrimes #{2 3 5 7} (set (take-while #(> 50 %) primes))))


;closure to store all primes till y
(defn acc [] 
  (let [x (atom #{})] 
    (fn [y] (swap! x conj y))))

(def acc1 (acc))

(defn filterfn [n]
      (areAllPrimes (allSplit n) (acc1 n)))

;removing 2 3 5 7 from the list to get 11.
(defn sol37 []
  (apply + (take 11 (reverse (take 15 (filter filterfn primes))))))