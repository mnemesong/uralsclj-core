(ns uralsclj-core.app
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]
            [uralsclj-core.declar :as d]
            [uralsclj-core.event :as e]))

(s/def ::declars #(and (coll? %) (every? d/valid? %)))
(s/def ::events #(and (map? %) (every? e/valid? (vals %))))
(s/def ::deps map?)
(s/def ::t 
    (s/keys 
        :req-un [::declars]
        :opt-un [::events ::deps]))

(defn valid? [x] (s/valid? ::t x))