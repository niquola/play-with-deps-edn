(defmulti task first)

(defmethod task :default
  [args]
  (let [all-tasks  (-> task methods (dissoc :default) keys sort)
        interposed (->> all-tasks (interpose ", ") (apply str))]
    (println "Unknown or missing task. Choose one of:" interposed)
    (System/exit 1)))

(require '[cljs.build.api :as api])

(def source-dir "src")

(def compiler-config {:main          'sample.core
                      :output-to     "target/sample/main.js"
                      :output-dir    "target/sample/main"
                      :target        :nodejs
                      :optimizations :simple
                      :source-map    "target/sample/main.js.map"})

(defmethod task "compile" [args]
  (api/build source-dir compiler-config))


(require '[figwheel-sidecar.repl-api :as repl-api :refer [cljs-repl]])

(def dev-config (merge compiler-config
                       {:optimizations :none
                        :source-map    true}))

(defmethod task "figwheel" [[_ port]]
  (repl-api/start-figwheel!
   {:figwheel-options (let [port "4444"]
                        {:nrepl-port       (some-> port Long/parseLong)
                         :nrepl-middleware ["cider.nrepl/cider-middleware"
                                            "refactor-nrepl.middleware/wrap-refactor"
                                            "cemerick.piggieback/wrap-cljs-repl"]})
    :all-builds       [{:id           "dev"
                        :figwheel     true
                        :source-paths [source-dir]
                        :compiler     dev-config}]})
  (when-not port
    (cljs-repl)))

(task *command-line-args*)
