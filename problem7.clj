(ns problem7  (:use clojure.test))

(use '[clojure.contrib.lazy-seqs :only (primes)])

;lil too easy with the primes sequence.
(is (= 104743 (nth primes 10000)))


