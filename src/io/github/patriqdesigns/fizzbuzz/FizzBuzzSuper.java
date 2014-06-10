package io.github.patriqdesigns.fizzbuzz;

/**
 * Created with IntelliJ IDEA.
 * User: André
 * <p/>
 * Date: 10/06/2014
 * Time: 18:46
 */
public abstract class FizzBuzzSuper {

    //A method to be override
    protected abstract FizzBuzz.Type evaluate(int i);

    //A filter just like the powerbot's one
    public interface Filter<T> {
        public boolean accept(T t);
    }

    public static class FizzBuzz extends FizzBuzzSuper {

        @Override
        //Will return the type that a given integer matches
        protected Type evaluate(int i) {
            for (Type t : Type.values()){
                if(t.filter.accept(i)) return t;
            }
            return null;
        }

        //enum that has all the result possibilities, NONE, FIZZ, BUZZ and FIZZBUZZ
        enum Type{
            NONE(new Filter<Integer>() {
                @Override
                public boolean accept(Integer integer) {
                    return integer % 5 != 0 && integer % 3 != 0;
                }
            }),
            FIZZ(new Filter<Integer>() {
                @Override
                public boolean accept(Integer integer) {
                    return integer % 3 == 0 && integer % 5 != 0;
                }
            }),
            BUZZ(new Filter<Integer>() {
                @Override
                public boolean accept(Integer integer) {
                    return integer % 3 != 0 && integer % 5 == 0;
                }
            }),
            FIZZ_BUZZ(new Filter<Integer>() {
                @Override
                public boolean accept(Integer integer) {
                    return integer % 3 == 0 && integer % 5 == 0;
                }
            });

            private Filter<Integer> filter;

            //All of them have a filter that given an integer will tell if they are that type
            //example:
            //FIZZ.filter.accept(3) will return true
            Type(Filter<Integer> filter) {
                this.filter = filter;
            }

            @Override
            public String toString() {
                if(this.equals(NONE)) return "";
                StringBuilder sb = new StringBuilder();
                for(String s : name().split("_")){
                    sb.append(s.substring(0,1).concat(s.substring(1).toLowerCase()));
                }
                return sb.toString().concat(": ");
            }
        }
    }
}