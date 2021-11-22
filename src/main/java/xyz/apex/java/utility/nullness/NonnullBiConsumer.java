package xyz.apex.java.utility.nullness;

import java.util.Objects;
import java.util.function.BiConsumer;

@FunctionalInterface
public interface NonnullBiConsumer<@NonnullType T, @NonnullType U> extends BiConsumer<T, U>
{
	@Override
	void accept(T t, U u);

	default NonnullBiConsumer<T, U> andThen(NonnullBiConsumer<? super T, ? super U> after)
	{
		Objects.requireNonNull(after);
		return (t, u) -> {
			accept(t, u);
			after.accept(t, u);
		};
	}

	static <@NonnullType T, @NonnullType U> NonnullBiConsumer<T, U> noop()
	{
		return (t, u) -> { };
	}
}
