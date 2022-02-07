#!/bin/sh
# shellcheck disable=SC2164

. ./setantenv.sh

cd ./app

ant destroy build jar run
