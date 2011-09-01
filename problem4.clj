(ns problem4  (:use clojure.test))

(defn ispalin? [num]
                 (let [s (str num)
                       split1 (rest (seq (. s split "")))
                       split2 (reverse split1)
                       ]
                  (every? #(true? %) (map #(= %1 %2) split1 split2))))

(is (true? (ispalin? 9009)))

(defn multa [num]
              (filter ispalin? (map #(* num %) (range num 99 -1))))
(defn soln4 []
           (last (sort (mapcat multa (range 999 99 -1)))))



(is (= 906609 (soln4)))
