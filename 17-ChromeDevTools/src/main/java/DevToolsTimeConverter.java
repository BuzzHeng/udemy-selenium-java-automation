import org.openqa.selenium.devtools.v137.network.model.MonotonicTime;
import org.openqa.selenium.devtools.v137.network.model.TimeSinceEpoch;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Maps Chrome DevTools MonotonicTime (seconds) to wall clock.
 * Usage:
 *   converter.captureOffset(wallTime, monotonic);
 *   Date d = converter.toDate(eventTimestamp);
 */
public class DevToolsTimeConverter {
    private volatile Double offsetSec = null; // wallTime - monoTime

    /** Capture offset using CDP's wallTime (UTC epoch seconds) and timestamp (monotonic seconds). */
    public void captureOffset(TimeSinceEpoch wallTime, MonotonicTime timestamp) {
        if (wallTime == null || timestamp == null) return;
        double wallSec = wallTime.toJson().doubleValue();     // seconds since 1970-01-01 UTC
        double monoSec = timestamp.toJson().doubleValue();    // CDP monotonic seconds
        if (this.offsetSec == null) {
            this.offsetSec = wallSec - monoSec;
        }
    }

    /** True once an offset is set. */
    public boolean isReady() {
        return offsetSec != null;
    }

    /** Convert a monotonic timestamp to epoch millis. */
    public long toEpochMillis(MonotonicTime ts) {
        if (!isReady()) throw new IllegalStateException("Offset not captured yet.");
        double monoSec = ts.toJson().doubleValue();
        return Math.round((monoSec + offsetSec) * 1000.0);
    }

    /** Convert a monotonic timestamp to java.util.Date (local timezone display). */
    public Date toDate(MonotonicTime ts) {
        return new Date(toEpochMillis(ts));
    }

    /** Convert a monotonic timestamp to Instant (UTC). */
    public Instant toInstant(MonotonicTime ts) {
        return Instant.ofEpochMilli(toEpochMillis(ts));
    }

    /** Convert a monotonic timestamp to ZonedDateTime with a specific zone. */
    public ZonedDateTime toZoned(MonotonicTime ts, ZoneId zone) {
        return ZonedDateTime.ofInstant(toInstant(ts), zone);
    }
}
