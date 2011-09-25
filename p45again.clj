(ns p45again)

(defn tfn [n]
  (/ (* n (inc n)) 2))
(defn pfn [n]
  (/ (* n (- (* 3 n) 1)) 2))
(defn hfn [n]
  (* n (- (* 2 n) 1)))

(def pvals (atom [[1 1]]))
(def hvals (atom [[1 1]]))

(defn iterfn [[x y]]
  (let [newx (inc x)]
    [newx (tfn newx)]))



(defn storeval [tval atomref atomfn]
  (let [atomval (deref atomref)
        lastpval (last (last atomval))
        lastn (first (last atomval))]
    (if (> tval lastpval)
      (reset! atomref [(last atomval) [(inc lastn) (atomfn (inc lastn))]]))))

(defn storep [tval]
  (storeval tval pvals pfn))

(defn storeh [tval]
  (storeval tval hvals hfn))

(defn pandhequals [tval]
  (and (= tval (last (last @pvals))) (= tval (last (last @hvals)))))


;(storep 7)
;@hvals
;(take 5 (iterate iterfn [1 1]))

(defn filterfn [[x y]]
  (do
    (storep y)
    (storeh y)
    (pandhequals y)))

(defn soln45 []
  (do
    (reset! pvals [[1 1]])
    (reset! hvals [[1 1]])
    (last (take 3 (filter filterfn (iterate iterfn [1 1]))))))
