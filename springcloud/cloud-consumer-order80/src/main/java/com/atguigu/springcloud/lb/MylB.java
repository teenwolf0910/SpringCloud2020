package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author ljw
 * @create 2020/3/18 15:22
 */
@Component
public class MylB  implements LoadBalancer{

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public  final  int getAndIncrement(){
        int current;
        int next;
        do{
            current =this.atomicInteger.get();
            next=current>=214748367 ? 0 :current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********第几次访问next:"+next);
        return  next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
      int index =  getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
