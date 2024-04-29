import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/** A bare-bones instrumentation logging class that records to System.out */
public class LoggingStatistics {

	public LoggingStatistics(){
	}

	private final Map<String, MethodStats> methodStats = new HashMap<>();
	
	private static class MethodStats {
		private int numCalls = 0;
		private long totalTimeMs = 0;
		
		public void recordCall(long timeInMs) {
			totalTimeMs += timeInMs;
			numCalls++;
		}
		
		public long getAverageMs() {
			return totalTimeMs / numCalls;
		}
		
		public long getTotalTimeMs() {
			return totalTimeMs;
		}
		
		public int getNumCalls() {
			return numCalls;
		}
	}
	
	/** Modify this method to record additional information */
	public void logMethod(String methodName, long totalTimeMs) {
		if (!methodStats.containsKey(methodName)) {
			methodStats.put(methodName, new MethodStats());
		}
		methodStats.get(methodName).recordCall(totalTimeMs);
	}
	
	public void printStats() {
		System.out.println("Methods by total time: ");
		
		List<Entry<String, MethodStats>> sortedEntries = new ArrayList<>(methodStats.entrySet());
		Collections.sort(sortedEntries, (e1, e2) -> {
			return Long.compare(e1.getValue().getTotalTimeMs(), e2.getValue().getTotalTimeMs());
		});
		
		sortedEntries.forEach(entry -> {
			System.out.println(entry.getKey() + ": " + entry.getValue().getTotalTimeMs());
		});
		
		// TODO: modify this method to get additional output
	}
}
