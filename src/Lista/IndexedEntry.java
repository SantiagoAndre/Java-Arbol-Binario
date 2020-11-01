package Lista;

    public class  IndexedEntry<E> implements Comparable<IndexedEntry<E>>
    {
        public final Integer index;
        public final E value;
        public final String strrep;

        public IndexedEntry(final int index, final E value)
        {
            this.index = index;
            this.value = value;
            this.strrep = String.format("%d:%s", this.index, this.value);
        }

        @Override
        public int compareTo(final IndexedEntry<E> o)
        {
            return this.index.compareTo(o.index);
        }

        /**
         * hashCode delegates to the contained .value hashCode implemenation
         * @return
         */
        @Override
        public int hashCode()
        {
            return this.value.hashCode();
        }

        /**
         * This returns <code>true</code> if the values are <code>equal</code>, it ignores the index
         * @param obj
         * @return
         */
        @Override
        public boolean equals(final Object obj)
        {
            return this.value.equals(obj);
        }

        @Override
        public String toString()
        {
            return this.strrep;
        }
    }