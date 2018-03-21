# clj -Sdeps '{:deps {pack/pack.alpha {:git/url "https://github.com/juxt/pack.alpha.git" :sha "eed89476315661e2389d5d078ec17375bec3efa5"}}}' -m mach.pack.alpha.jcl deps.edn app.jar build_dir
clj -Sdeps '{:deps {pack/pack.alpha {:git/url "https://github.com/juxt/pack.alpha.git" :sha "bb2c5a2c78aca9328e023b029c06ba0efdd1e3b7"}}}' -m mach.pack.alpha.capsule deps.edn app.jar build_dir myapp 0.0.1

