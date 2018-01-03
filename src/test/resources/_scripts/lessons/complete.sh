#!/usr/bin/env bash

OUTPUT="$(echo $0 | sed 's#sh#json#g' | sed 's#^#../#g')"

curl --silent \
    -H 'Authorization: Bearer '${CDA_TOKEN}  \
    'https://cdn.contentful.com/spaces/'${SPACE_ID}'/entries?sys.id=2SAYsnajosIkCOWqSmKaio&include=2' \
    | python -m json.tool \
    > ${OUTPUT}
