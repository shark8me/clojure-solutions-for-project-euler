(ns p17 (:use clojure.test))

(def almap 
  {1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"
   20 "twenty"
   30 "thirty"
   40 "forty"
   50 "fifty"
   60 "sixty"
   70 "seventy"
   80 "eighty"
   90 "ninety"})

(defn get-longform [ in]
  (if (> in 20)
    (if (>= in 100)
      (let [hundreds-part (quot in 100)
            tens-part (* (rem (quot in 10) 10) 10)
            ones-part (rem in 10)]
        (str (almap hundreds-part) 
             (if (and (== 0 tens-part) (== 0 ones-part) ) 
               " hundred"
               " hundred and " ) 
             (if (== tens-part 10) 
               (almap (+ tens-part ones-part)) 
               (str (almap tens-part) 
               (if (== 0 ones-part) "" (str " " (almap ones-part)))))))
    (let [bal (rem in 10)
          tens-part (* 10 (quot in 10))]
      (str (almap tens-part) " " (almap bal))))
    (almap in)))
  
(is (= (get-longform 1) "one"))
(is (= (get-longform 12) "twelve"))
(is (= (get-longform 21) "twenty one"))
(is (= (get-longform 25) "twenty five"))
(is (= (get-longform 31) "thirty one"))
(is (= (get-longform 99) "ninety nine"))
(is (= (get-longform 102) "one hundred and  two"))
(is (= (get-longform 270) "two hundred and seventy"))
(is (= (get-longform 272) "two hundred and seventy two"))
(is (= (get-longform 699) "six hundred and ninety nine"))
(is (= (get-longform 900) "nine hundred"))
(is (= (get-longform 100) "one hundred"))

(defn charcount [instr]
  (count (filter #(. Character isLetter %) instr)))

(is (= (charcount "twentyone") 9))

(defn wcount []
  (apply + (map charcount (map get-longform (range 1 1000)))))

(+ (charcount "one thousand") (wcount))




