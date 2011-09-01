(ns problem52 (:use clojure.test))

(defn digits [num]
           (set (map #(. Integer parseInt % ) (rest (. (str num) split  "")))))

(is (= #{1 2 3 4} (digits 1234)))

(defn digits-equal? [s1 s2]
  (= s1 s2))

(is (true? (digits-equal? (digits 1234) (digits 1234))))
(is (false? (digits-equal? (digits 1234) (digits 1235))))


(defn xd [mult num ]
     (digits-equal? (digits num) (digits (* num mult))))

;need to find a way to shorten this
(defn soln52[]
(first (filter (partial xd 6) 
               (filter (partial xd 5) 
                       (filter (partial xd 4) 
                               (filter (partial xd 3) 
                                       (filter (partial xd 2) 
                                               (iterate inc 1))))))))

(is (= 142857 (soln52)))