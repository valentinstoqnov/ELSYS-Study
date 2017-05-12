using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyLengthConverter
{
    class Converter
    {
        public static string[] items = { "kilometer", "meter", "centimeter", "milimeter", "inch" };
        private string from;
        private string to;
        private double value;
        private double convertedValue;

        public Converter(string from, string to, double value)
        {
            this.from = from;
            this.to = to;
            this.value = value;
            proceed();
        }

        private void proceed()
        {
            if(from == to)
            {
                calculateAndSet(0.0, '+');
            }else if((from == items[0] && to == items[1]) || (from == items[1] && to == items[0]))
            {
                if(from == items[0] && to == items[1])
                {
                    calculateAndSet(1000, '*');
                }else
                {
                    calculateAndSet(1000, '/');
                }
            }else if((from == items[0] && to == items[2]) || (from == items[2] && to == items[0]))
            {
                if (from == items[0] && to == items[2])
                {
                    calculateAndSet(100000, '*');
                }
                else
                {
                    calculateAndSet(100000, '/');
                }
            }
            else if ((from == items[0] && to == items[3]) || (from == items[3] && to == items[0]))
            {
                if (from == items[0] && to == items[3])
                {
                    calculateAndSet(1000000, '*');
                }
                else
                {
                    calculateAndSet(1000000, '/');
                }
            }
            else if ((from == items[0] && to == items[4]) || (from == items[4] && to == items[0]))
            {
                if (from == items[0] && to == items[4])
                {
                    calculateAndSet(39370.1, '*');
                }
                else
                {
                    calculateAndSet(39370.1, '/');
                }
            }
            else if ((from == items[1] && to == items[2]) || (from == items[2] && to == items[1]))
            {
                if (from == items[1] && to == items[2])
                {
                    calculateAndSet(100, '*');
                }
                else
                {
                    calculateAndSet(100, '/');
                }
            }
            else if ((from == items[1] && to == items[3]) || (from == items[3] && to == items[1]))
            {
                if (from == items[1] && to == items[3])
                {
                    calculateAndSet(1000, '*');
                }
                else
                {
                    calculateAndSet(1000, '/');
                }
            }
            else if ((from == items[1] && to == items[4]) || (from == items[4] && to == items[1]))
            {
                if (from == items[1] && to == items[4])
                {
                    calculateAndSet(39.3701, '*');
                }
                else
                {
                    calculateAndSet(39.3701, '/');
                }
            }
            else if ((from == items[2] && to == items[3]) || (from == items[3] && to == items[2]))
            {
                if (from == items[2] && to == items[3])
                {
                    calculateAndSet(10, '*');
                }
                else
                {
                    calculateAndSet(10, '/');
                }
            }
            else if ((from == items[2] && to == items[4]) || (from == items[4] && to == items[2]))
            {
                if (from == items[2] && to == items[4])
                {
                    calculateAndSet(0.393701, '*');
                }
                else
                {
                    calculateAndSet(0.393701, '/');
                }
            }
            else if ((from == items[3] && to == items[4]) || (from == items[4] && to == items[3]))
            {
                if (from == items[3] && to == items[4])
                {
                    calculateAndSet(0.0393701, '*');
                }
                else
                {
                    calculateAndSet(0.0393701, '/');
                }
            }
        }

        private void calculateAndSet(double key, char operation)
        {
            switch (operation)
            {
                case '+':
                    convertedValue = value + key;
                    break;
                case '-':
                    convertedValue = value - key;
                    break;
                case '*':
                    convertedValue = value * key;
                    break;
                case '/':
                    convertedValue = value / key;
                    break;
            }
        }

        public void setFrom(string from)
        {
            this.from = from;
        }

        public void setTo(string to)
        {
            this.to = to;
        }

        public void setValue(double value)
        {
            this.value = value;
        }

        public string getFrom()
        {
            return from;
        }

        public string getTo()
        {
            return to;
        }

        public double getValue()
        {
            return value;
        }

        public double getConvertedValue()
        {
            return convertedValue;
        }
    }
}
