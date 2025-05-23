import os
import subprocess

import build_kotlin

if "RUN_DIR" in os.environ.keys():
    home = os.environ['RUN_DIR']
else:
    home = os.path.expanduser('~') + "/IdeaProjects/versions-parent"

def run_prcesses():
    build_kotlin.build_kotlin_fn()

run_prcesses()