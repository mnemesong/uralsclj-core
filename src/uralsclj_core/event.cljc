(ns uralsclj-core.event
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]))

(defmulti handle 
    (fn [
        h ;;event-handler
        e ;;event-name
        s ;;state-map
        d ;;dependencies-map
    ] (e)))

(s/def ::t #(contains? (methods handle) %))

(defn valid? [x] (s/valid? ::t x))