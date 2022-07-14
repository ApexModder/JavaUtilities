package xyz.apex.java.utility.api;

import org.jetbrains.annotations.Nullable;

import xyz.apex.java.utility.api.nullness.NotNullSupplier;
import xyz.apex.java.utility.api.nullness.NotNullType;
import xyz.apex.java.utility.api.nullness.NullableSupplier;
import xyz.apex.java.utility.api.nullness.NullableType;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * A {@link Supplier} who caches the values received from {@link #get()}
 * and returns this same value until the lazy is invalidated using {@link #invalidate()}.
 *
 * @param <T> Type of value to lazily get.
 * @see Supplier
 */
public interface Lazy<T> extends Supplier<T>
{
	/**
	 * Attempt to retrieve and cache value to be lazily returned later.
	 *
	 * @return Lazily obtained value from {@link Supplier}.
	 * @see Supplier#get()
	 */
	@Override T get();

	/**
	 * Invalidates the {@link Lazy} object.
	 * Future calls to {@link #get()} will try to retrieve and cache the value again.
	 */
	void invalidate();

	/**
	 * Creates a new {@link Lazy} object that allows returning null values.
	 *
	 * @param supplier The backing {@link NullableSupplier Supplier} used to retrieve values from.
	 * @param concurrent Whether this {@link Lazy} should be concurrent or not (Thread safe).
	 * @param <T> The backing object type for this {@link Lazy}.
	 * @see Supplier
	 * @see NullableSupplier
	 * @return A new {@link Lazy} that allows null values.
	 */
	static <@NullableType T> Lazy<T> ofNullable(NullableSupplier<T> supplier, boolean concurrent)
	{
		return concurrent ? new ConcurrentNullableLazy<>(supplier) : new NullableLazy<>(supplier);
	}

	/**
	 * Creates a new {@link Lazy} object that allows returning null values.
	 * (This {@link Lazy} is not concurrent / thread safe).
	 *
	 * @param supplier The backing {@link NullableSupplier Supplier} used to retrieve values from.
	 * @param <T> The backing object type for this {@link Lazy}.
	 * @see Supplier
	 * @see NullableSupplier
	 * @see #ofNullable(NullableSupplier, boolean)
	 * @return A new {@link Lazy} that allows null values.
	 */
	static <@NullableType T> Lazy<T> ofNullable(NullableSupplier<T> supplier)
	{
		return ofNullable(supplier, false);
	}

	/**
	 * Creates a new {@link Lazy} object whose resulting objects must never be null.
	 *
	 * @param supplier The backing {@link NotNullSupplier Supplier} used to retrieve values from.
	 * @param concurrent Whether this {@link Lazy} should be concurrent or not (Thread safe).
	 * @param <T> The backing object type for this {@link Lazy}.
	 * @see Supplier
	 * @see NotNullSupplier
	 * @return A new {@link Lazy} that does not allow null values.
	 */
	static <@NotNullType T> Lazy<T> of(NotNullSupplier<T> supplier, boolean concurrent)
	{
		return concurrent ? new ConcurrentNotNullLazy<>(supplier) : new NotNullLazy<>(supplier);
	}

	/**
	 * Creates a new {@link Lazy} object whose resulting objects must never be null.
	 * (This {@link Lazy} is not concurrent / thread safe).
	 *
	 * @param supplier The backing {@link NotNullSupplier Supplier} used to retrieve values from.
	 * @param <T> The backing object type for this {@link Lazy}.
	 * @see Supplier
	 * @see NotNullSupplier
	 * @return A new {@link Lazy} that does not allow null values.
	 */
	static <@NotNullType T> Lazy<T> of(NotNullSupplier<T> supplier)
	{
		return of(supplier, false);
	}

	/**
	 * A {@link Lazy} that allows null values.
	 *
	 * @param <T> Type of value to lazily get.
	 * @see Lazy
	 * @see Supplier
	 * @see NullableSupplier
	 */
	final class NullableLazy<T> implements Lazy<T>, NullableSupplier<T>
	{
		private final NullableSupplier<T> supplier;
		@Nullable private T instance = null;
		private boolean initialized = false;

		private NullableLazy(NullableSupplier<T> supplier)
		{
			this.supplier = supplier;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see Lazy#get()
		 */
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

		/**
		 * {@inheritDoc}
		 *
		 * @see Lazy#invalidate()
		 */
		@Override
		public void invalidate()
		{
			instance = null;
			initialized = false;
		}
	}

	/**
	 * Concurrent (Thread safe) variant of {@link NullableLazy}.
	 *
	 * @param <T> Type of value to lazily get.
	 * @see Lazy
	 * @see NullableLazy
	 * @see Supplier
	 * @see NullableSupplier
	 */
	@SuppressWarnings({ "FieldMayBeFinal", "SynchronizationOnLocalVariableOrMethodParameter" })
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

		/**
		 * {@inheritDoc}
		 *
		 * @see Lazy#get()
		 */
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

		/**
		 * {@inheritDoc}
		 *
		 * @see Lazy#invalidate()
		 */
		@Override
		public void invalidate()
		{
			instance = null;
			initialized = false;
		}
	}

	/**
	 * A {@link Lazy} whose values must never be null.
	 *
	 * @param <T> Type of value to lazily get.
	 * @see Lazy
	 * @see Supplier
	 * @see NotNullSupplier
	 */
	final class NotNullLazy<T> implements Lazy<T>, NotNullSupplier<T>
	{
		private final NotNullSupplier<T> supplier;
		@Nullable private T instance = null;
		private boolean initialized = false;

		private NotNullLazy(NotNullSupplier<T> supplier)
		{
			this.supplier = supplier;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see Lazy#get()
		 */
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

		/**
		 * {@inheritDoc}
		 *
		 * @see Lazy#invalidate()
		 */
		@Override
		public void invalidate()
		{
			instance = null;
			initialized = false;
		}
	}

	/**
	 * Concurrent (Thread safe) variant of {@link NotNullLazy}.
	 *
	 * @param <T> Type of value to lazily get.
	 * @see Lazy
	 * @see NotNullLazy
	 * @see Supplier
	 * @see NotNullLazy
	 */
	@SuppressWarnings({ "FieldMayBeFinal", "SynchronizationOnLocalVariableOrMethodParameter" })
	final class ConcurrentNotNullLazy<T> implements Lazy<T>, NotNullSupplier<T>
	{
		private volatile NotNullSupplier<T> supplier;
		@Nullable private volatile T instance = null;
		private volatile boolean initialized = false;
		private volatile Object lock = new Object();

		private ConcurrentNotNullLazy(NotNullSupplier<T> supplier)
		{
			this.supplier = supplier;
		}

		/**
		 * {@inheritDoc}
		 *
		 * @see Lazy#get()
		 */
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

		/**
		 * {@inheritDoc}
		 *
		 * @see Lazy#invalidate()
		 */
		@Override
		public void invalidate()
		{
			instance = null;
			initialized = false;
		}
	}
}