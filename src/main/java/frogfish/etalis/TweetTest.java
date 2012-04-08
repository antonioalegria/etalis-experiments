package frogfish.etalis;

import com.jtalis.core.JtalisContextImpl;
import com.jtalis.core.event.provider.DefaultInputProvider;
import com.jtalis.core.event.provider.DefaultOutputProvider;
import com.jtalis.core.plengine.JPLEngineWrapper;
import com.jtalis.core.plengine.PrologEngineWrapper;

public class TweetTest {
	public static void main(String[] args) throws Exception {
		PrologEngineWrapper<?> engine = new JPLEngineWrapper(false);

		JtalisContextImpl ctx = new JtalisContextImpl(engine);
		ctx.addEventTrigger("a/_", "d/_");
		ctx.addDynamicRule("d(X) <- a(X) where X > 25");

		ctx.registerOutputProvider(new DefaultOutputProvider());
		ctx.registerInputProvider(new DefaultInputProvider());

		ctx.waitForInputProviders();
		ctx.shutdown();
	}
}
