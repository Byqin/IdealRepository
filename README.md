# IdealRepository
demo

# 技术记录
 Java ScriptEngine 动态执行代码
 CSRF,XXS网络攻击
 Swagger 是一个规范和完整的框架，用于生成、描述、调用和可视化 REST 风格的 Web 服务。
# 编码规范
 OOA/OOP/OOD
 设计模式
# jvm
 Young generation –>新生代
 Tenured / Old Generation –>老年代
 Perm Area –>永久代
 年轻代：
 
    分为：一个Eden区，两个 Survivor区(一般而言)
 年老代:
 
     在年轻代中经历了N次垃圾回收后仍然存活的对象，就会被放到年老代中。因此，可以认为年老代中存放的都是一些生命周期较长的对象。
 持久代:
 
     用于存放静态文件，如今Java类、方法等。持久代对垃圾回收没有显著影响，但是有些应用可能动态生成或者调用一些class，
     例如Hibernate 等，在这种时候需要设置一个比较大的持久代空间来存放这些运行过程中新增的类。持久代大小通过-XX:MaxPermSize=<N>进行设置。
 
 Minor GC发生在新生代，当Eden区没有足够空间时，会发起一次Minor GC，将Eden区中的存活对象移至Survivor区。Major GC发生在老年代，当升到老年代的对象大于老年代剩余空间时会发生Major GC。
 发生Major GC时用户线程会暂停，会降低系统性能和吞吐量。
 
# 常用jvm参数   
 -Xms              初始堆大小  
 -Xmx              最大堆大小  
 -Xmn              年轻代大小  注意：此处的大小是（eden+ 2 survivor space).与jmap -heap中显示的New gen是不同的。整个堆大小=年轻代大小 + 年老代大小 + 持久代大小.增大年轻代后,将会减小年老代大小.此值对系统性能影响较大,Sun官方推荐配置为整个堆的3/8
 -XX:NewSize       年轻代大小
 -XX:MaxNewSize    设置年轻代大小(for 1.3/1.4)
 -XX:PermSize      设置持久代(perm gen)初始值
 -XX:MaxPermSize   设置持久代最大值
 -XX:NewRatio      年轻代(包括Eden和两个Survivor区)与年老代的比值(除去持久代) 
 -XX:SurvivorRatio Eden区与Survivor区的大小比值
