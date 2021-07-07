package com.qubole.sparklens

import org.apache.spark.{SparkConf, SparkContext}

object AppTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("te")
      .set("spark.extraListeners", "com.qubole.sparklens.QuboleJobListener")
    //    发送邮件
    //      .set("spark.sparklens.report.email","1040080742@qq.com")
    //    取消控制台打印
    //      .set("spark.sparklens.reporting.disabled","true")
    val sc = SparkContext.getOrCreate(sparkConf)
    val rdd = sc.parallelize(List(1, 2, 3))
    println(rdd.collect().mkString(","))
  }

}
