package xyz.apex.java.utility;

import xyz.apex.java.utility.nullness.NonnullSupplier;
import xyz.apex.java.utility.nullness.NonnullType;
import xyz.apex.java.utility.nullness.NullableSupplier;
import xyz.apex.java.utility.nullness.NullableType;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

public interface Lazy<T> extends Supplier<T>
{
	@Override T get();

	void invalidate();

	static <@NullableType T> Lazy<T> ofNullable(NullableSupplier<T> supplier, boolean concurrent)
	{
		return concurrent ? new ConcurrentNullableLazy<>(supplier) : new NullableLazy<>(supplier);
	}

	static <@NullableType T> Lazy<T> ofNullable(NullableSupplier<T> supplier)
	{
		return ofNullable(supplier, false);
	}

	static <@NonnullType T> Lazy<T> of(NonnullSupplier<T> supplier, boolean concurrent)
	{
		return concurrent ? new ConcurrentNonnullLazy<>(supplier) : new NonnullLazy<>(supplier);
	}

	static <@NonnullType T> Lazy<T> of(NonnullSupplier<T> supplier)
	{
		return of(supplier, false);
	}

	@SuppressWarnings("NullableProblems")
	final class NullableLazy<T> implements Lazy<T>, NullableSupplier<T>
	{
		private final NullableSupplier<T> supplier;
		@Nullable private T instance = null;
		private boolean initialized = false;

		private NullableLazy(NullableSupplier<T> supplier)
		{
			this.supplier = supplier;
		}

		@Nullable
		@Override
		public T get()
		{
			if(!initialized)
			{
				instance = supplier.get();
				initialized = true;
			}

			return instance;
		}

		@Override
		public void invalidate()
		{
			instance = null;
			initialized = false;
		}
	}

	@SuppressWarnings({ "FieldMayBeFinal", "SynchronizationOnLocalVariableOrMethodParameter", "NullableProblems" })
	final class ConcurrentNullableLazy<T> implements Lazy<T>, NullableSupplier<T>
	{
		private volatile NullableSupplier<T> supplier;
		@Nullable private volatile T instance = null;
		private volatile boolean initialized = false;
		private volatile Object lock = new Object();

		private ConcurrentNullableLazy(NullableSupplier<T> supplier)
		{
			this.supplier = supplier;
		}

		@Nullable
		@Override
		public T get()
		{
			Object localLock = lock;

			if(!initialized)
			{
				synchronized(localLock)
				{
					if(!initialized)
					{
						instance = supplier.get();
						initialized = true;
					}
				}
			}

			return instance;
		}

		@Override
		public void invalidate()
		{
			instance = null;
			initialized = false;
		}
	}

	final class NonnullLazy<T> implements Lazy<T>, NonnullSupplier<T>
	{
		private final NonnullSupplier<T> supplier;
		@Nullable private T instance = null;
		private boolean initialized = false;

		private NonnullLazy(NonnullSupplier<T> supplier)
		{
			this.supplier = supplier;
		}

		@Override
		public T get()
		{
			if(!initialized)
			{
				instance = supplier.get();
				initialized = true;
			}

			return Objects.requireNonNull(instance);
		}

		@Override
		public void invalidate()
		{
			instance = null;
			initialized = false;
		}
	}

	@SuppressWarnings({ "FieldMayBeFinal", "SynchronizationOnLocalVariableOrMethodParameter" })
	final class ConcurrentNonnullLazy<T> implements Lazy<T>, NonnullSupplier<T>
	{
		private volatile NonnullSupplier<T> supplier;
		@Nullable private volatile T instance = null;
		private volatile boolean initialized = false;
		private volatile Object lock = new Object();

		private ConcurrentNonnullLazy(NonnullSupplier<T> supplier)
		{
			this.supplier = supplier;
		}

		@Override
		public T get()
		{
			Object localLock = lock;

			if(!initialized)
			{
				synchronized(localLock)
				{
					if(!initialized)
					{
						instance = supplier.get();
						initialized = true;
					}
				}
			}

			return Objects.requireNonNull(instance);
		}

		@Override
		public void invalidate()
		{
			instance = null;
			initialized = false;
		}
	}
}
