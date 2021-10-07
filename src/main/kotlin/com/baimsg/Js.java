package com.baimsg;


import java.math.BigDecimal;

public class Js {
    public double Js(final String str)
    {
        return Js(str, BigDecimal.ROUND_DOWN);
    }
    public double Js(final String str, final int bdtype)
    {
        return new Object() {
            int pos = -1, ch;

            void nextChar()
            {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat)
            {
                while (ch == ' ') nextChar();
                if (ch == charToEat)
                {
                    nextChar();

                    return true;
                }
                return false;
            }

            double parse()
            {
                nextChar();
                double x = parseExpression();
                System.out.println(x);
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression()
            {

                BigDecimal x = new BigDecimal(parseAndSub());

                for (;;)
                {

                    if (eat('&'))x = new BigDecimal(x.toBigInteger().and(new BigDecimal(parseAndSub()).toBigInteger()));
                    else if (eat('|'))x = new BigDecimal(x .toBigInteger().or(new BigDecimal(parseAndSub()).toBigInteger()));
                    else return x.doubleValue();
                }
            }


            double parseAndSub()
            {
                double x = parseTerm();
                for (;;)
                {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm()
            {
                BigDecimal x = new BigDecimal(parseFactor());

                for (;;)
                {
                    if      (eat('*')) x = x.multiply(new BigDecimal(parseFactor())); // multiplication
                    else if (eat('/')) x = x.divide(new BigDecimal(String.valueOf(parseFactor())), 16, bdtype); // division
                    else if (eat('%')) x = x.divideAndRemainder(new BigDecimal(String.valueOf(parseFactor())))[1]; // division

                    else return x.doubleValue();
                }
            }

            double parseFactor()
            {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('('))
                { // parentheses
                    x = parseExpression();
                    eat(')');
                }
                else if ((ch >= '0' && ch <= '9') || ch == '.')
                { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                }
                else if (ch >= 'a' && ch <= 'z')
                { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                }
                else
                {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
                if (eat('^')) x=new BigDecimal(x).pow(new BigDecimal(parseFactor()).intValue()).doubleValue();

                return x;
            }
        }.parse();
    }

}


