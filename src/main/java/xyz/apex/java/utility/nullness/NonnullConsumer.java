package xyz.apex.java.utility.nullness;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
public interface NonnullConsumer<@NonnullType T> extends Consumer<T>
{
	@Override
	void accept(T t);

	default NonnullConsumer<T> andThen(NonnullConsumer<? super T> after)
	{
		Objects.requireNonNull(after);
		return t -> {
			accept(t);
			after.accept(t);
		};
	}

	static <@NonnullType T> NonnullConsumer<T> noop()
	{
		return t -> { };
	}
}
