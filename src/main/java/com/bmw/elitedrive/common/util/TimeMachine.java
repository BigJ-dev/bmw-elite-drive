package com.bmw.elitedrive.common.util;

import java.time.Clock;
import java.time.Instant;

public class TimeMachine {
    public static Instant getNow() {
        return Instant.now(Clock.systemUTC());
    }
}
