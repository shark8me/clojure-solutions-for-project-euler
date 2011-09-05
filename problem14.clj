(ns problem14 (:use clojure.test))

(defn nextNum [n]
  (if (even? n) (/ n 2) (+ 1 (* 3 n))))

(is (= 40 (nextNum 13)))
(is (= 20 (nextNum 40)))

(defn nseq [n]
           (take-while #(not= 1 %) (iterate problem14/nextNum n)))

(is (= '(13 40 20 10 5 16 8 4 2) (nseq 13)))

(defn vecWithCount [num]
     (map #(vector % (count (nseq %))) (range 1 num)))

(is (= '([1 0] [2 1] [3 7] [4 2]) (vecWithCount 5)))

(defn findLargestPair [num]
     (reduce #(if (> (last %1) (last %2)) %1 %2) (vecWithCount num)))

(is (= [19 20] (findLargestPair 20)))

;takes a couple of minutes to solve
;(findLargestPair 1000000)
;[837799 524]



