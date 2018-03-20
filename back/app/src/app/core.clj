(ns app.core
  (:gen-class))

(defn run []
  (println "run!"))

(defn -main [& args]
  (println "main" args)
  (run))

