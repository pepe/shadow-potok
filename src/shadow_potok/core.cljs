(ns shadow-potok.core
  (:require [potok.core :as ptk]))

(def store (ptk/store {:state {:init false}}))

(defrecord Init []
    ptk/UpdateEvent
    (update [_ state]
      (assoc state :init true))
    ptk/EffectEvent
    (effect [_ state _] (println state)))


(defn main [argv]
  (ptk/emit! store (->Init)))
