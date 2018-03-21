(require '[clojure.tools.nrepl.server :refer [start-server]]
         '[cider.nrepl :refer [cider-nrepl-handler]])

(let [port 7888]
  (start-server :port port :handler cider-nrepl-handler)
  (println "Started nREPL on port" port))
