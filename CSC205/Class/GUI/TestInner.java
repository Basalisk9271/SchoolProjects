
public class TestInner
{
        public static void main(String[] args)
        {
                Inner i = new Inner();



        }
}

class Inner
{
        private int myId;
        public Inner()
        {
                myId = 0;
                Inner.Inside j = new Inner.Inside();


        }

        class Inside
        {
                public Inside()
                {
                                myId = -1;
                }



        }
}

