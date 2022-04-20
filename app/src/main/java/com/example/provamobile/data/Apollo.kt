package com.example.provamobile.data

import com.apollographql.apollo3.ApolloClient

val apolloClient = ApolloClient
    .Builder()
    .serverUrl("https://us-central1-ss-devops.cloudfunctions.net/GraphQL")
    .build()
