package MLBasic;

import java.util.ArrayList;
import java.util.List;

public class mlBasic {

    //二分类（正负样本比），多分类（样本均衡）
    //1.准确率 ： 预测对的样本 / 样本总数
    public static double accuracyRate (double[] prob, double[] label, double thresold) {
        int num = label.length;
        double accnum = 0;
        for (int i = 0; i < num; i++) {
            if (prob[i] > thresold && label[i] == 1.0) {
                accnum++;
            }
            else if (prob[i] <= thresold && label[i] == 0.0) {
                accnum++;
            }
        }
        return accnum / num;
    }

    //2.错误率 ： 预测错的样本 / 样本总数
    public static double errorRate (double[] prob, double[] label, double thresold) {
        return 1 - accuracyRate(prob, label, thresold);
    }

    //混淆矩阵
    //        标签P  标签N
    //预测P    TP     FP     precision
    //预测N    FN     TN
    //       recall

    //3.精确率 ： 预测对的正样本(TP) / 预测为正样本的个数(T)  对应混淆矩阵行
    public static double precisionRate (double[] prob, double[] label, double thresold) {
        double tpNum = 0.0;
        double num = 0.0;
        int len = label.length;
        for (int i = 0; i < len; i++) {
            if (prob[i] > thresold) {
                num++;
                if (label[i] - 1.0 == 0) {
                    tpNum++;
                }
            }
        }
        return tpNum / (num + 1e-10);
    }

    //4.召回率 ：预测对的正样本(TP) / 样本总的正样本(P)   对应混淆矩阵列
    public static double recallRate (double[] prob, double[] label, double thresold) {
        double tpNum = 0.0;
        double pNum = 0.0;
        int len = label.length;
        for (int i = 0; i < len; i++) {
            if (label[i] == 1.0) {
                pNum++;
                if (prob[i] > thresold) {
                    tpNum++;
                }
            }
        }
        return tpNum / (pNum + 1e-10);
    }

    //5.F1score : 2 / F1 = 1 / P + 1 / R
    //F1 = (2 * P * R) / (P + R)
    public static double f1Scode (double[] prob, double[] label, double thresold) {
        double p = precisionRate(prob, label, thresold);
        double r = recallRate(prob, label, thresold);
        return (2 * p * r) / (p + r + 1e-10);
    }


    //auc
    //面积法 ： 梯形面积之和

    //概率法 ：
    /*
    1.构建正负样本对，笛卡尔积
    2.计算分母：正样本个数 * 负样本个数
    3.计算分子：严样本对中 正样本概率 > 负样本概率 的个数
    */

    public static double aucProb (double[] prob, double[] label) {
        double res = 0.0;
        int posNum = 0;
        List<Double> posProb = new ArrayList<>();
        int negNum = 0;
        List<Double> negProb = new ArrayList<>();
        int num = label.length;
        double pos2Neg = 0.0;
        for (int i = 0; i < num; i++) {
            if (label[i] == 0) {
                negNum++;
                negProb.add(prob[i]);
                continue;
            }
            posNum++;
            posProb.add(prob[i]);
        }
        for (int i = 0; i < posNum; i++) {
            for (int j = 0; j < negNum; j++) {
                if (posProb.get(i) > negProb.get(j)) {
                    pos2Neg++;
                    continue;
                }
                if (posProb.get(i) == negProb.get(j)) {
                    pos2Neg = pos2Neg + 0.5;
                }
            }
        }
        return pos2Neg / (posNum * negNum);
    }



    public static void main(String[] args) {
        double[] prob = new double[]{0.1, 0.4, 0.5 ,0.6, 0.35, 0.8, 0.9, 0.4, 0.25, 0.5};
        double[] label = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        System.out.println(precisionRate(prob,label,0.5));
        System.out.println(recallRate(prob,label,0.5));
        System.out.println(f1Scode(prob,label,0.5));
    }
}
