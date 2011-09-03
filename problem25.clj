(ns problem25)

(defn fibseq []
               (map #(list %1 %2) (map first (iterate (fn [[x y]] [(+ x y) x]) [0 1])) (iterate inc 0)))

(defn getIthFibWithDigitSizeGreaterThan [digits]
     (second (first (filter #(< digits (count (rest (. (str (first %)) split "")))) (fibseq)))))
 