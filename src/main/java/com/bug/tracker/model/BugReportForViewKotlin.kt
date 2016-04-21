package com.bug.tracker.model

import java.time.LocalDateTime

class BugReportForViewKotlin(var id: Int = 0,
                             var title: String = "",
                             var summary: String = "",
                             var stepsToReproduce: String = "",
                             var actualResult: String = "",
                             var expectedResult: String = "",
                             var reporter: String = "",
                             var assigned: String = "",
                             var status: String = "",
                             var priority: String = "",
                             var date: LocalDateTime = LocalDateTime.now()
)

