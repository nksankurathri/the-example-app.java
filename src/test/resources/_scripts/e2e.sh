#!/usr/bin/env bash

if [ -z "$@" ]; then
    COMMAND="open";
else
    COMMAND="run";
fi

../the-example-app-e2e-tests/node_modules/.bin/cypress ${COMMAND} --env LANGUAGE=java,CONTENTFUL_QA_SPACE_ID=jnzexv31feqf,CONTENTFUL_QA_DELIVERY_TOKEN=7c1c321a528a25c351c1ac5f53e6ddc6bcce0712ecebec60817f53b35dd3c42b,CONTENTFUL_QA_PREVIEW_TOKEN=4310226db935f0e9b6b34fb9ce6611e2061abe1aab5297fa25bd52af5caa531a,CONTENTFUL_SPACE_ID=qz0n5cdakyl9,CONTENTFUL_DELIVERY_TOKEN=580d5944194846b690dd89b630a1cb98a0eef6a19b860ef71efc37ee8076ddb8,CONTENTFUL_PREVIEW_TOKEN=e8fc39d9661c7468d0285a7ff949f7a23539dd2e686fcb7bd84dc01b392d698b