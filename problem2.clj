(ns problem2 (:use clojure.test)) 

(defn fibo []
  (map first (iterate (fn [[x y]] [(+ x y) x]) [1 1])))

(is (= '(1 2 3 5 8) (take 5 (fibo))))


(is (= '(2 8 34) (take 3 (filter even? (take-while #(< % 4000000) (fibo))))))
    
    
(defn soln2 []
  (apply + (filter even? (take-while #(< % 4000000) (fibo)))))

(is (= 4613732 (soln2)))
