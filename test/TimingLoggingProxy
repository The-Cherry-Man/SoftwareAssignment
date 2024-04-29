import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** A wrapper around an interface that tracks the time each of its methods takes */
public class TimingLoggingProxy {
	
	public static <T> T createProxy(T wrappedObject, Class<T> proxyClass, LoggingStatistics stats) {
		return (T) Proxy.newProxyInstance(TimingLoggingProxy.class.getClassLoader(), new Class[] {proxyClass}, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				long timeStart = System.currentTimeMillis();
				Object result = method.invoke(wrappedObject, args);
				long timeEnd = System.currentTimeMillis();
				stats.logMethod(proxyClass.getCanonicalName()+"." + method.getName(), (timeEnd - timeStart));
				return result;
			}});
	}

}
