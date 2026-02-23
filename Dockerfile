FROM credem.jfrog.io/dockerredhataccess/ubi9/openjdk-25-runtime:#{base-jdk-version}# AS SVCIMAGE



ARG TARGET_JAR_PATH
ARG TARGET_JAR_NAME


ENV JAVA_INITIAL_MEM_RATIO=80.0
ENV JAVA_MAX_MEM_RATIO=80.0
ENV ENV_TARGET_JAR_NAME=${TARGET_JAR_NAME}

USER root
COPY ./certs/* /etc/pki/ca-trust/source/anchors/

RUN mkdir /app && \
    chown -R 185:root /app && \
    chmod -R 755 /app && \
    rm -f /etc/localtime && \
    ln -s /usr/share/zoneinfo/Europe/Rome /etc/localtime && \
    update-ca-trust


USER 185

COPY ./${TARGET_JAR_PATH}/${TARGET_JAR_NAME} /app

WORKDIR /app

RUN echo "java -XX:InitialRAMPercentage=${JAVA_INITIAL_MEM_RATIO} -XX:MaxRAMPercentage=${JAVA_MAX_MEM_RATIO} -jar ${ENV_TARGET_JAR_NAME} \$@" > run_app.sh

ENTRYPOINT ["/bin/bash", "/app/run_app.sh"]