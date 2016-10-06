######################### STANDALONE  #########################


features:addurl mvn:info.keyal/spark-features/1.0.0-SNAPSHOT/xml/features




######################### FABRIC  #########################


1. First create fabric using
		fabric:create --zookeeper-password admin --wait-for-provisioning

2. Create a new A-MQ standalone broker profile
		mq-create --kind StandAlone --group sparkgroup sparkbroker-profile

	This creates two profiles
		JBossFuse:karaf@root> profile-list | grep spark
		mq-broker-sparkgroup.sparkbroker-profile                  mq-base
		mq-client-sparkgroup                                      mq-client-base

3. Create a child container (sparkbroker-container) as the A-MQ broker using the sparkbroker-profile profile
		container-create-child --profile mq-broker-sparkgroup.sparkbroker-profile root sparkbroker-container

	This will create sparkbroker-container continer
		JBossFuse:karaf@root> container-list | grep spark
		sparkbroker-container  1.0        karaf   yes          mq-broker-sparkgroup.sparkbroker-profile  success

4. Create spark-profile
        profile-create --parents feature-camel sparkasdf-profile
        profile-edit --feature camel-amq sparkasdf-profile
        profile-edit --bundle mvn:info.keyal/spark-processor/1.0-SNAPSHOT sparkasdf-profile
        profile-edit --bundle  mvn:org.apache.activemq/activemq-osgi/5.11.0.redhat-621084

4. Run the following deploy command to create spark-profile which contains spark :: processor
		mvn fabric8:deploy

	Note: You need to add the following in pom.xml
		<fabric8.profile>spark-profile</fabric8.profile>
		<fabric8.parentProfiles>feature-camel</fabric8.parentProfiles>
		<fabric8.features>camel-amq</fabric8.features>

	This will create the following profile
		JBossFuse:karaf@root> profile-list | grep spark
		mq-broker-sparkgroup.sparkbroker-profile  1               mq-base
		mq-client-sparkgroup                                      mq-client-base
		spark-profile                                             feature-camel

5. Create a new child container called sparkcontainer and deploy the spark-profile profile in a single step, by entering the following command at the console. Notice we have to add `--profile mq-client-sparkgroup` so the client connects to correct A-MQ group; as you can have multiple broker groups in fabric8.
		container-create-child --profile spark-profile --profile mq-client-sparkgroup root sparkcontainer
		container-create-child --profile sparkasdf-profile --profile mq-client-sparkgroup root sparkcontainer


