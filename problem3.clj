(ns problem3 (:use clojure.test))

(use '[clojure.contrib.lazy-seqs :only (primes)])
(defn divby [num divisor]
     (if (zero? (rem num divisor)) (divby (/ num divisor) divisor) num))

(is (= 125 (divby 2000 2)))
(is (= 5 (divby 20 2)))

(defn rediv [lst1]
     (loop [lst lst1]
         (if (== 1 (first (first lst)))
           lst
           (recur (let [num (first (first lst))
                    divisor (last (first lst))
                    remains (divby num divisor)
                    nextprime (first (filter #(< divisor %) primes))
                    ]
                    (if (== remains num)
                      (cons [remains nextprime] (rest lst))
                    (cons [remains nextprime] lst)))
           )
         )
     )
     )

(is (= '([1 31] [29 29] [377 13] [2639 7] [13195 5]) (rediv [[13195 (first primes)]])))

(defn soln3 [num]
           (first (rest (map (comp last rest) (rediv [[num (first primes)]])))))

(is (= 29 (soln3 13195)))
(is (= 6857 (soln3 600851475143)))

