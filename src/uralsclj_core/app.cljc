(ns uralsclj-core.app
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]
            [uralsclj-core.declar :as d]))

(s/def ::declars #(and (coll? %) (every? d/valid? %)))
(s/def ::events coll?)
(s/def ::deps coll?)
(s/def ::t 
    (s/keys 
        :req-un [::declars]
        :opt-un [::events ::deps]))

(defn valid? [x] (s/valid? ::t x))