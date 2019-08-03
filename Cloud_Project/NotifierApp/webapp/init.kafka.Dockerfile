FROM confluentinc/cp-kafka:5.2.1
WORKDIR /

COPY ./topic.sh /usr/local/bin/topic.sh
RUN ln -s usr/local/bin/topic.sh /

ENTRYPOINT ["bash","topic.sh"]