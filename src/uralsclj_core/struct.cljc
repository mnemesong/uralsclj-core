(ns uralsclj-core.struct
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]
            [uralsclj-core.model :as m]))

(defn has-no-empty-prop [s p]
    {:pre [(coll? s)]}
    (and 
        (contains? s p) 
        (> (count (get s p)) 0)))
    
(defn replace-property [s k m]
    {:pre [(coll? s)]}
    (if 
        (has-no-empty-prop s k) 
        (assoc s k (m/render-to-template (get s k) m))
        s))

(defn has-keys? 
    ([c] (> (count c) 0))
    ([c ks] (->> ks
        (map #(contains? c %))
        (every? true?))))