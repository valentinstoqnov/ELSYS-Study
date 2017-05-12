using System;
using System.Drawing;
using System.Windows.Forms;

namespace MyLengthConverter
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            string[] items = { "inch", "milimeter", "centimeter", "meter", "kilometer" };
            comboBoxFrom.DataSource = Converter.items;
            comboBoxTo.DataSource = items; 
        }

        private void btnConvert_Click(object sender, EventArgs e)
        {
            string from = comboBoxFrom.Text;
            string to = comboBoxTo.Text;
            double number;
            if (Double.TryParse(textBoxLength.Text, out number))
            {
                if (number > 0.0)
                {
                    Converter converter = new Converter(from, to, number);
                    labelResult.ForeColor = Color.Green;
                    labelResult.Text = converter.getConvertedValue().ToString();
                }else
                {
                    labelResult.ForeColor = Color.Red;
                    labelResult.Text = "Length is always positive number";
                }
            }
            else
            {
                labelResult.ForeColor = Color.Red;
                labelResult.Text = "Number is expected";
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
