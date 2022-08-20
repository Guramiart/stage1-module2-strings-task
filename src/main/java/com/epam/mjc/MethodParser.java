package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        MethodSignature methodSignature;
        List<MethodSignature.Argument> argumentList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(signatureString, "()");
        String method = stringTokenizer.nextToken();
        if (stringTokenizer.hasMoreTokens()) {
            String args = stringTokenizer.nextToken();
            StringTokenizer argsTokenizer = new StringTokenizer(args, ",");
            while (argsTokenizer.hasMoreTokens()) {
                String arg = argsTokenizer.nextToken().trim();
                String[] argArr = arg.split(" ");
                argumentList.add(new MethodSignature.Argument(argArr[0], argArr[1]));
            }
        }
        StringTokenizer methodTokenizer = new StringTokenizer(method);
        if(methodTokenizer.countTokens() == 3) {
            String accessModifier = methodTokenizer.nextToken();
            String returnType = methodTokenizer.nextToken();
            methodSignature = new MethodSignature(methodTokenizer.nextToken(), argumentList);
            methodSignature.setAccessModifier(accessModifier);
            methodSignature.setReturnType(returnType);
        } else {
            String returnType = methodTokenizer.nextToken();
            methodSignature = new MethodSignature(methodTokenizer.nextToken(), argumentList);
            methodSignature.setReturnType(returnType);
        }
        return methodSignature;
    }
}
